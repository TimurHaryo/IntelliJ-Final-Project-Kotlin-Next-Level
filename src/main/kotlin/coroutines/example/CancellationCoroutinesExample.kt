package coroutines.example

import kotlinx.coroutines.*

fun main() {
    scopeCancellationCoroutines(true)
    jobCancellationCoroutines(
        shouldCancelJob1 = true,
        shouldCancelJob2 = false,
    )
}

fun scopeCancellationCoroutines(shouldCancel: Boolean) = runBlocking {
    val scope = CoroutineScope(SupervisorJob())
    val job1 = scope.launch {
        delay(1000)
        println("Job 1 scopeCancellationCoroutines finished")
    }
    val job2 = scope.launch {
        delay(2000)
        println("Job 2 scopeCancellationCoroutines finished")
    }

    delay(1000)  // Wait for some time
    if (shouldCancel) {
        scope.cancel()  // Cancel all coroutines within the scope
    }
    delay(4000)  // Wait for some time
    println(
        message = """
               ================
               > job1 scopeCancellationCoroutines is cancelled: ${job1.isCancelled}
               > job2 scopeCancellationCoroutines is cancelled: ${job2.isCancelled}
               ================
           """.trimIndent(),
    )

    println("Main thread scopeCancellationCoroutines continues...")
    println()
}

fun jobCancellationCoroutines(
    shouldCancelJob1: Boolean,
    shouldCancelJob2: Boolean,
) = runBlocking {
    val scope = CoroutineScope(SupervisorJob())
    val job1 = scope.launch {
        delay(2000)
        println("Job 1 jobCancellationCoroutines finished")
    }
    val job2 = scope.launch {
        delay(2000)
        println("Job 2 jobCancellationCoroutines finished")
    }

    delay(1000)
    if (shouldCancelJob1) {
        job1.cancel()
    }
    if (shouldCancelJob2) {
        job2.cancel()
    }
    delay(4000)
    println(
        message = """
               ================
               > job1 is jobCancellationCoroutines cancelled: ${job1.isCancelled}
               > job2 is jobCancellationCoroutines cancelled: ${job2.isCancelled}
               ================
           """.trimIndent(),
    )

    println("Main thread jobCancellationCoroutines continues...")
    println()
}