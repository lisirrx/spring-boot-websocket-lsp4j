package com.example.demo;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.websocket.WebSocketEndpoint;

public class LspEndpoint extends WebSocketEndpoint<LanguageClient>{

    @Override
    protected void configure(Launcher.Builder<LanguageClient> builder) {
        builder.setLocalService(new LspLanguageServer());
        builder.setRemoteInterface(LanguageClient.class);
        builder.setExceptionHandler(throwable -> {
            System.out.println(throwable.getMessage());
            return new ResponseError(0, throwable.getMessage(), throwable);
        });
        System.out.println("Builder");
    }
}
