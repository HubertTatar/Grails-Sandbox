package movierental.rental

import grails.converters.JSON


class RentalController {

    RentalService rentalService

    def create(CreateCommand cc) {
        if (cc.hasErrors()) {
            response.status = 400
            return
        }

        Rental create = rentalService.create(cc.movie, cc.user)
        Map result = [
                'result': create
        ]
        render result as JSON
    }

    def list() {
        List<Rental> list = rentalService.list()
        Map result = [
                'result': list
        ]
        render result as JSON
    }

    def find(GetCommand gc) {
        if (gc.hasErrors()) {
            response.status = 400
            return
        }


        Map result = [
                'result': rentalService.findById(gc.id)
        ]
        render result as JSON
    }

    def update(UpdateCommand uc) {
        if (uc.hasErrors()) {
            response.status = 400
            return
        }

        Map result = [
                'result': rentalService.update(new Rental(movie: uc.movie, user:  uc.user))
        ]
        render result as JSON
    }

    def updatePart() {
        response.status = 500
    }

    def delete(DeleteCommand dc) {
        if (dc.hasErrors()) {
            response.status = 400
            return
        }

        rentalService.delete(dc.id)
        response.status = 200
    }
}
