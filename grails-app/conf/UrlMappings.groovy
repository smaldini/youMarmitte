class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(controller:'recipe')
        "/u/$username"(controller:'recipe')
        
		"500"(view:'/error')
	}
}
