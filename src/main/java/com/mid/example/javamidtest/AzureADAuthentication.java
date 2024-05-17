package com.mid.example.javamidtest;

import com.azure.core.credential.AccessToken;
import com.azure.core.credential.SimpleTokenCache;
import com.azure.core.credential.TokenCredential;
import com.azure.core.credential.TokenRequestContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AzureADAuthentication {
    private static final String  AZURE_AD_DATABASE_SCOPE = "https://database.windows.net/.default";
    private final SimpleTokenCache cache;
    	
    // private static final Logger logger = LoggerFactory.getLogger(AzureADAuthentication.class);

    public AzureADAuthentication(TokenCredential credential) {
        log.debug("RHYMOND::AzureADAuthentication");

        cache = new SimpleTokenCache(() -> credential.getToken(createRequestContext()));
        
    }

    public String getAccessToken() {
        log.debug("RHYMOND::getAccessToken");

        final AccessToken accessToken = cache.getToken()
        .retry(1L)
        .blockOptional()
        .orElseThrow(() -> new RuntimeException("Attempt to retrieve the AAD token failed"));

        return accessToken.getToken();
    }

    private TokenRequestContext createRequestContext() {
        log.info("RHYMOND::createRequestContext");
	        
        return new TokenRequestContext()
        .addScopes(AZURE_AD_DATABASE_SCOPE)
        .setTenantId("9ec6e2d0-6c2d-4b06-b014-daca41adf2fe");
    }    
}
