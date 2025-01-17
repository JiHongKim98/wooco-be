package kr.wooco.woocobe.plan.domain.usecase

import kr.wooco.woocobe.common.domain.usecase.UseCase
import kr.wooco.woocobe.plan.domain.gateway.PlanStorageGateway
import kr.wooco.woocobe.plan.domain.model.Plan
import org.springframework.stereotype.Service

data class GetPlanInput(
    val userId: Long,
    val planId: Long,
)

data class GetPlanOutput(
    val plan: Plan,
)

@Service
class GetPlanUseCase(
    private val planStorageGateway: PlanStorageGateway,
) : UseCase<GetPlanInput, GetPlanOutput> {
    override fun execute(input: GetPlanInput): GetPlanOutput {
        val plan = planStorageGateway.getByPlanId(input.planId)

        return GetPlanOutput(
            plan = plan,
        )
    }
}
