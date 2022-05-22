public class GreetingService {

    public String hello() {
        return "hello";
    }

    @LogInvocation
    public String gloryToUkraine() {
        return "Glory to Ukraine!";
    }
}
