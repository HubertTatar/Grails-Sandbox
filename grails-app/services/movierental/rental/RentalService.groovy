package movierental.rental

import grails.gorm.transactions.Transactional


class RentalService {

    RentalDBService rentalDBService

    @Transactional
    Rental create(String movie, String user) {
        Rental rental = new Rental(movie: movie, user: user)
        return rentalDBService.save(rental)
    }

    @Transactional(readOnly = true)
    Rental findById(Serializable id) {
        return rentalDBService.findById(id)
    }

    @Transactional
    void delete(Serializable id) {
        rentalDBService.delete(id)
    }

    @Transactional(readOnly = true)
    List<Rental> list() {
        return rentalDBService.list()
    }

    @Transactional
    Rental update(Rental rental) {
        return rentalDBService.save(rental)
    }

}
