package movierental.rental

import grails.gorm.services.Service

@Service(Rental)
interface RentalDBService {
    Rental findById(Serializable id)
    List<Rental> list()
    void delete(Serializable id)
    Rental save(Rental rental)
}
