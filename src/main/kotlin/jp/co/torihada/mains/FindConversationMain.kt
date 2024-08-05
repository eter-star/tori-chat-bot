package jp.co.torihada.mains

import jp.co.torihada.usecases.FindingConversation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FindConversationMain : BaseMain() {

    override suspend fun execute(args: Array<String>) {
        FindingConversation.execute(args[0])
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runBlocking {
                launch(Dispatchers.Default) {
                    FindConversationMain().runMain(args)
                }.join()
            }
        }
    }


}