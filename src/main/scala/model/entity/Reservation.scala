package model.entity

import model.repository.ReservationRepository

class Reservation (room: Room, timetable: Timetable, user: User) {
  val id: Int = getReservationId()
  def getReservationId(): Int = {
    ReservationRepository.getNextReservationId
  }
}
