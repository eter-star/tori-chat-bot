package jp.co.torihada.mains

import jp.co.torihada.usecases.FindingConversation
import jp.co.torihada.usecases.ParsingMessages
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ParseMessagesMain : BaseMain() {


    override suspend fun execute(args: Array<String>) {
        ParsingMessages.execute()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runBlocking {
                launch(Dispatchers.Default) {
                    ParseMessagesMain().runMain(args)
                }.join()
            }
        }
    }


}