package jp.co.torihada.usecases


import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.slack.api.Slack
import com.slack.api.methods.SlackApiException
import com.slack.api.methods.request.conversations.ConversationsHistoryRequest.ConversationsHistoryRequestBuilder
import com.slack.api.model.Message
import com.sun.org.apache.xml.internal.serializer.utils.Utils.messages
import jp.co.torihada.config.Config
import kotlinx.coroutines.Dispatchers.Main
import org.slf4j.LoggerFactory
import java.io.IOException


object RetrievingMessage {

    @JvmStatic
    fun execute(): List<Message>? {

        val yamlMapper = ObjectMapper(YAMLFactory()).registerModule(KotlinModule())
        val inputStream = Main::class.java.getResourceAsStream("/application-local.yaml")
        val config: Config = yamlMapper.readValue(inputStream)

        val channelId = config.slack.channel_id
        val slackBotToken = config.slack.slack_bot_token

        val client = Slack.getInstance().methods()
        val logger = LoggerFactory.getLogger("tori-chatbot-slack-app")
        try {
            val result = client.conversationsHistory { r: ConversationsHistoryRequestBuilder ->
                r
                    .token(slackBotToken)
                    .channel(channelId)
                    .inclusive(true)
                    .limit(Int.MAX_VALUE)
            }

            return result.messages

        } catch (e: IOException) {
            logger.error("error: {}", e.message, e)
        } catch (e: SlackApiException) {
            logger.error("error: {}", e.message, e)
        }

        return null
    }
}


