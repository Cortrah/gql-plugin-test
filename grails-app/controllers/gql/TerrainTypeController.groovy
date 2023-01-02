package gql

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TerrainTypeController {

    TerrainTypeService terrainTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond terrainTypeService.list(params), model:[terrainTypeCount: terrainTypeService.count()]
    }

    def show(Long id) {
        respond terrainTypeService.get(id)
    }

    def create() {
        respond new TerrainType(params)
    }

    def save(TerrainType terrainType) {
        if (terrainType == null) {
            notFound()
            return
        }

        try {
            terrainTypeService.save(terrainType)
        } catch (ValidationException e) {
            respond terrainType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'terrainType.label', default: 'TerrainType'), terrainType.id])
                redirect terrainType
            }
            '*' { respond terrainType, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond terrainTypeService.get(id)
    }

    def update(TerrainType terrainType) {
        if (terrainType == null) {
            notFound()
            return
        }

        try {
            terrainTypeService.save(terrainType)
        } catch (ValidationException e) {
            respond terrainType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'terrainType.label', default: 'TerrainType'), terrainType.id])
                redirect terrainType
            }
            '*'{ respond terrainType, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        terrainTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'terrainType.label', default: 'TerrainType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'terrainType.label', default: 'TerrainType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
