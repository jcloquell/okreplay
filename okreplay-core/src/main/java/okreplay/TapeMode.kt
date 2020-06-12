package okreplay

import okreplay.TapeMode.OrderingMode.*

enum class TapeMode(val isReadable: Boolean, val isWritable: Boolean, val orderingMode: OrderingMode) {

  UNDEFINED(false, false, SINGLE), READ_WRITE(true, true, SINGLE), READ_ONLY(true, false, SINGLE),
  READ_ONLY_QUIET(true, false, SINGLE), READ_SEQUENTIAL(true, false, SEQUENTIAL),
  WRITE_ONLY(false, true, SINGLE), WRITE_SEQUENTIAL(false, true, SEQUENTIAL),
  WRITE_QUEUE(false, true, QUEUE), READ_QUEUE(true, false, QUEUE);

  /**
   * For compatibility with Groovy truth.
   */
  fun asBoolean(): Boolean {
    return isReadable || isWritable
  }

  fun toNullable(): TapeMode? {
    return if (this == UNDEFINED) null else this
  }

  fun isSequential(): Boolean {
    return orderingMode == SEQUENTIAL
  }

  fun isQueued(): Boolean {
    return orderingMode == QUEUE
  }

  enum class OrderingMode {
    SINGLE, SEQUENTIAL, QUEUE
  }
}
