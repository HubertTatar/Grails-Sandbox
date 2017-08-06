package movierental

class UrlMappings {

    static mappings = {
        "/movies"(resources:"Movie")
        "/movieTypes"(resources:"MovieType")
        "/horror"(controller: 'movie', action: 'horror')
        "/sse"   (controller: 'sse'  , action: 'events')
        "/eventsSimple"   (controller: 'sse'  , action: 'eventsSimple')
        "/eventsInterval"   (controller: 'sse'  , action: 'eventsInterval')

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
