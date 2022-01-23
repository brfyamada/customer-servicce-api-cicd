//[SLACK] [step 3] Criar uma classe para enviar Alertas para o slack

package br.com.byamada.customerserviceapi.util;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@PropertySource("classpath:application.properties")
public class SlackAlertSender {

    private static String SLACK_WEBHOOKS_URL;

    @Autowired
    public void loadOnelinkConfig(@Value("${slack.webhooks-url}") String url) {
        SLACK_WEBHOOKS_URL = url;
    }

    public static void sendAlert(String message){
        log.info("VALOR DA URL = {}",SLACK_WEBHOOKS_URL);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(message);

            Payload payload = Payload.builder()
                    .text(stringBuilder.toString())
                    .build();

            WebhookResponse response = Slack.getInstance()
                    .send(SLACK_WEBHOOKS_URL, payload);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
