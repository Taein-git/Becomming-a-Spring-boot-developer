package me.taein.springbootdeveloper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {

    @GetMapping("/quiz") // 1
    public ResponseEntity<String> quiz(@RequestParam("code") int code) {
        switch (code) {
            case 1:
                return ResponseEntity.created(null).body("Created!");
            case 2:
                return ResponseEntity.badRequest().body("Bad Request!");
            default:
                return ResponseEntity.ok().body("OK!");
        }
    }

    @PostMapping("/quiz") // 2
    public ResponseEntity<String> quiz2(@RequestBody Code code) {
        switch (code.value()) {
            case 1:
                return ResponseEntity.status(403).body("Forbidden!");
            default:
                return ResponseEntity.ok().body("OK!");
        }
    }
}

record Code(int value) {} // 3
// 레코드: 필드, 생성자, 게터, equals(), hashCode(), toString() 자동 생성
