package contracts
import org.springframework.cloud.contract.spec.Contract
Contract.make {
    description "Should return all posts"

    request {
        method GET()
        url "/posts"
    }

    response {
        status 200
        headers {
            contentType(applicationJson())
        }
        body([
                [
                        profile: "java developer",
                        desc: "Senior Software engineer with java skillset expert in core",
                        exp: 5,
                        techs: ["java", "jee", "spring", "springboot", "microservices", "threads"]
                ],
                [
                        profile: "Block chain",
                        desc: "Ethereum",
                        exp: 2,
                        techs: ["Java", "Solidity"]
                ]
        ])
    }
}
