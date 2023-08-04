package edu.center.edu_center.Controller;

import edu.center.edu_center.Service.PupilService;
import edu.center.edu_center.Utils.AppConstant;
import edu.center.edu_center.payload.ApiResponse;
import edu.center.edu_center.payload.ReqPupil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pupil")
public class    PupilController {

    private final PupilService pupilService;
    @PostMapping
    public HttpEntity<?> addPupil(@RequestBody ReqPupil reqPupil){
        ApiResponse apiResponse = pupilService.addPupil(reqPupil);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/page")
    public HttpEntity<?> getPage(@RequestParam(name = "page", defaultValue = AppConstant.APP_DEFAULT_PAGE)int page, @RequestParam(name = "size", defaultValue = AppConstant.APP_TOTAL_AGE) int size){
        ApiResponse pupilPage = pupilService.getPupilPage(page, size);
        return ResponseEntity.ok(pupilPage);
    }
}
