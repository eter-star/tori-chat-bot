package jp.co.torihada.mains

import jp.co.torihada.usecases.RetrievingMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RetrieveMessageMain : BaseMain(){

    override suspend fun execute(args: Array<String>) {
        RetrievingMessage.execute()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runBlocking {
                launch(Dispatchers.Default) {
                    RetrieveMessageMain().runMain(args)
                }.join()
            }
        }
    }

}