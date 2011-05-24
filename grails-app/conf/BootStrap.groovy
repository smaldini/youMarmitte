class BootStrap {

    def init = { servletContext ->

        def someString = 'test'

        someString.toLowerCase()

    }
    def destroy = {
    }
}
