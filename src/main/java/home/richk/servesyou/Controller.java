package home.richk.servesyou;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Controller {
	//X-MS-CLIENT-PRINCIPAL-NAME
	//X-MS-CLIENT-PRINCIPAL-ID
    @RequestMapping("/")
    public String index(@RequestHeader(value="X-MS-CLIENT-PRINCIPAL-NAME", defaultValue = "") String idToken,
    		@RequestHeader(value="X-MS-CLIENT-PRINCIPAL-ID", defaultValue = "") String accessToken,
    		@RequestHeader(value="X-MS-TOKEN-AAD-EXPIRES-ON", defaultValue = "") String expires,
    		@RequestHeader(value="X-MS-TOKEN-AAD-REFRESH-TOKEN", defaultValue = "") String refreshToken) 
    {
    	String result = "main: ";
    	if (idToken != null)
    		result = result.concat("idToken:").concat(idToken).concat(" ");
    	if (accessToken != null)
    		result = result.concat("accessToken:").concat(accessToken).concat(" ");
    	if (expires != null)
    		result = result.concat("expires:").concat(expires).concat(" ");
    	if (refreshToken != null)
    		result = result.concat("refreshToken:").concat(refreshToken).concat(" ");
    	return result;
    }
    @RequestMapping("/hello")
    public String hello() {
        return "Hi Richie Rich! the version is: " + Application.searchURL();
    }
    @RequestMapping("/bye")
    public String bye() {
        return "Bye bye Richie Rich! the key is: " + Application.searchKEY();
    }
    @RequestMapping("/wait")
    public String waitRichie() {
        return "Wait for me Richie!";
    }
    @RequestMapping("/show")
    public String showme() {
        return "Show them to me!";
    }
}
