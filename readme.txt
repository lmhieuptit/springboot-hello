query = "fetch cloud_run_revision\n| metric 'run.googleapis.com/container/memory/utilizations'\n| align delta(5m)\n| every 5m\n| group_by [resource.service_name], [value_memory_utilization: mean(val())]\n| condition val() > 0.8"

query = "fetch cloud_run_revision | metric 'run.googleapis.com/container/cpu/utilizations' | align delta(1m) | every 1m | group_by [resource.service_name], [percentile(value, 0.95)] | condition val() > 0.8"

resource "google_monitoring_alert_policy" "cloudrun_memory_mql" {
  display_name = "Cloud Run Memory Utilization > 80% for 15min"
  combiner     = "OR"

  conditions {
    display_name = "MQL Memory Utilization Condition > 80%"
    condition_monitoring_query_language {
      duration = "60s" 

      query = <<EOT
fetch cloud_run_revision
| metric 'run.googleapis.com/container/memory/utilizations'
| align delta(5m)
| every 5m
| group_by [resource.service_name],
    [value_memory_utilization: mean(val())]
| condition val() > 0.8
EOT
    }
  }

  notification_channels = [google_monitoring_notification_channel.email_alert.name]

  documentation {
    content = "Memory utilization exceeded 80% for 15 minutes."
  }

  alert_strategy {
    notification_channel_strategy {
      renotify_interval = "3600s"
    }
  }

  user_labels = {
    severity = "critical"
  }
}