package jp.co.torihada.mains

abstract class BaseMain {

    abstract suspend fun execute(args: Array<String>)

    suspend fun runMain(args: Array<String>){
        try {
            execute(args)
        }catch (e: Exception){
            e.printStackTrace()
            return
        }
    }
}