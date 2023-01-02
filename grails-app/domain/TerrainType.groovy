
class TerrainType {
    String name = "Unknown"
    String code = "?"
    String description = "A Mystery"

    Integer landCost = null
    Integer airCost = null
    Integer navalCost = null

    String toString() {"$name"}

    static graphql = true
    static constraints = {
        name blank: false
        code blank: false
        description nullable: true

        landCost nullable: true
        airCost nullable: true
        navalCost nullable: true
    }
}
