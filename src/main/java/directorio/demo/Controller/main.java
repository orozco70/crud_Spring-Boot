package directorio.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class main {

	@GetMapping(value = {"","/"})
	public String main()
	{
		return "main";
	}
}
