package movierental

class UrlMappings {

    static mappings = {
        "/movies"(resources:"Movie")
        "/movieTypes"(resources:"MovieType")
        "/horror"(controller: 'movie', action: 'horror')
        "/sse"   (controller: 'sse'  , action: 'events')
        "/sse2"   (controller: 'sse'  , action: 'events2')
        "/quartz"   (controller: 'sse'  , action: 'quartz')
        "/quartz2"   (controller: 'sse'  , action: 'quartz2')
        "/eventsSimple"   (controller: 'sse'  , action: 'eventsSimple')
        "/eventsInterval"   (controller: 'sse'  , action: 'eventsInterval')

        get '/rental'        (controller: 'rental', action: 'list')
        get "/rental/$id"    (controller: 'rental', action: 'find')
        post '/rental'       (controller: 'rental', action: 'create')
        put "/rental/$id"    (controller: 'rental', action: 'update')
        patch "/rental/$id"  (controller: 'rental', action: 'updatePart')

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
