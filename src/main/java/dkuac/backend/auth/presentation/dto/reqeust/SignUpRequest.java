package dkuac.backend.auth.presentation.dto.reqeust;

public record SignUpRequest(
        String name,
        String email,
        String major,
        int studentNumber,
        String birth,
        String phone
) {
}
