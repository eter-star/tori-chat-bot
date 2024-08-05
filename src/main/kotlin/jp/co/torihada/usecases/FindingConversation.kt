package jp.co.torihada.usecases

import com.slack.api.Slack
import com.slack.api.methods.SlackApiException
import io.ktor.utils.io.errors.*
import org.slf4j.LoggerFactory

object FindingConversation {

    /**
     * Find conversation ID using the conversations.list method
     */
    @JvmStatic
    fun execute(name: String) {

        val client = Slack.getInstance().methods()
        val logger = LoggerFactory.getLogger("tori-chatbot-slack-app")
        val slackBotToken = "xoxb-7519330947701-7524737465108-Sh7HzCUc48JtX2HqLJJfbFyB"
        try {
            val result = client.conversationsList { r -> r
                .token(slackBotToken)
            }
            for (channel in result.channels) {
                if (channel.name == name) {
                    val conversationId = channel.id
                    logger.info("Found conversation ID: {}", conversationId)
                    break
                }
            }
        } catch (e: IOException) {
            logger.error("error: {}", e.message, e)
        } catch (e: SlackApiException) {
            logger.error("error: {}", e.message, e)
        }
    }

}
