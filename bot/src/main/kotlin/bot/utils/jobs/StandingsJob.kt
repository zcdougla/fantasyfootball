package bot.utils.jobs

import bot.bridges.MessageBridge
import bot.bridges.StandingsBridge
import org.quartz.Job
import org.quartz.JobExecutionContext
import bot.messaging_services.Message
import bot.utils.DataRetriever

class StandingsJob : Job {
    override fun execute(context: JobExecutionContext?) {
        println("Running Standings Update Job...")

        val header = Message.Generic("📣 <b>STANDINGS ALERT</b> 🔢\\n━━━━━━━━━━━━━")
        MessageBridge.dataObserver.onNext(header)

        val data = DataRetriever.getStandings()
        StandingsBridge.dataObserver.onNext(data)
    }

}
