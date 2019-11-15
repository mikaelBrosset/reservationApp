package model.entity

case class Room (roomName: String) {
  def isReserved(timetable: Timetable): Boolean = {
    true
  }

  def isFree(timetable: Timetable): Boolean = {
    ! this.isReserved(timetable)
  }
}
