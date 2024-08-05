package jp.co.torihada.config

data class Slack(val slack_bot_token: String, val channel_id: String)
data class Config(val env: String, val slack: Slack)