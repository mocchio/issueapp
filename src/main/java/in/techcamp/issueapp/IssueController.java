package in.techcamp.issueapp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class IssueController {

    private final IssueRepository issueRepository;

    // イシュー投稿フォームの表示
    @GetMapping("/issueForm")
    public String showIssueForm(@ModelAttribute("issueForm") IssueForm form){
        return "issueForm";
    }

    // イシュー投稿機能
    @PostMapping("/issues")
    public String createIssue(IssueForm issueForm){
        issueRepository.insert(issueForm.getTitle(), issueForm.getContent(), issueForm.getPeriod(), issueForm.getImportance());
        return "redirect:/";
    }

    // 一覧表示機能
    @GetMapping
    public String showIssues(Model model){
        var issueList = issueRepository.findAll();
        model.addAttribute("issueList", issueList);
        return "index";
    }

    // イシュー詳細表示機能
    @GetMapping("/issues/{id}")
    public String issueDetail(@PathVariable long id, Model model) {
        var issue = issueRepository.findById(id);
        model.addAttribute("issue", issue);
        return "detail";
    }

    // イシュー更新機能
    @PostMapping("/issues/{id}/update")
    public String updateIssue(@PathVariable lond id, IssueForm issueForm) {
        issueRepository.update(issueForm.getTitle(), issueForm.getContent(), issueForm.getPeriod(), issueForm.getImportance());
        return "redirect:/";
    }
}
