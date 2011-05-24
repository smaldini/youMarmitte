class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller:'recipe')
        "/user/$username"(controller:'recipe')
        
		"500"(view:'/error')
	}
}
