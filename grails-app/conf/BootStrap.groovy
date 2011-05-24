import youmarmitte.Role
import grails.util.Environment
import youmarmitte.User
import youmarmitte.UserRole

class BootStrap {

    def springSecurityService
    def testService

    def init = { servletContext ->

        def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save()

        //if(Environment.DEVELOPMENT == Environment.current){

            def user

            ['smaldini','luis','test','peter'].each{
                user = new User(username: it,
                        password: springSecurityService.encodePassword('test'),
                        enabled: true).save()

                UserRole.create user, userRole
            }

//        }

    }
    def destroy = {
    }
}
