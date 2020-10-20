package com.example.demo;

import com.google.common.collect.Lists;
import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.services.LanguageServer;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.services.WorkspaceService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class LspLanguageServer implements LanguageServer {

    @Override
    public CompletableFuture<InitializeResult> initialize(InitializeParams initializeParams) {
        System.out.println("initialize");
        final InitializeResult res = new InitializeResult(new ServerCapabilities());
        res.getCapabilities().setCodeActionProvider(Boolean.FALSE);
        res.getCapabilities().setCompletionProvider(new CompletionOptions(true, Lists.newArrayList(".")));
        res.getCapabilities().setDefinitionProvider(Boolean.FALSE);
        res.getCapabilities().setHoverProvider(Boolean.FALSE);
        res.getCapabilities().setReferencesProvider(Boolean.FALSE);
        res.getCapabilities().setTextDocumentSync(TextDocumentSyncKind.Full);
        res.getCapabilities().setDocumentSymbolProvider(Boolean.FALSE);

        return CompletableFuture.supplyAsync(() -> res);
    }

    @Override
    public CompletableFuture<Object> shutdown() {
        System.out.println("shutdown");
        return CompletableFuture.completedFuture("");
    }

    @Override
    public void exit() {
        System.out.println("EXIT");
    }

    @Override
    public TextDocumentService getTextDocumentService() {
        return new TextDocumentService() {
            @Override
            public CompletableFuture<Either<List<CompletionItem>, CompletionList>> completion(CompletionParams position) {
                List<CompletionItem> list = Lists.newArrayList(new CompletionItem("123"));
                CompletionList completionList = new CompletionList();

                return CompletableFuture.completedFuture(Either.forLeft(list));
            }

            @Override
            public CompletableFuture<CompletionItem> resolveCompletionItem(CompletionItem unresolved) {
                return null;
            }

            @Override
            public CompletableFuture<Hover> hover(HoverParams params) {
                return null;
            }

            @Override
            public CompletableFuture<SignatureHelp> signatureHelp(SignatureHelpParams params) {
                return null;
            }

            @Override
            public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> declaration(DeclarationParams params) {
                return null;
            }

            @Override
            public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> definition(DefinitionParams params) {
                return null;
            }

            @Override
            public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> typeDefinition(TypeDefinitionParams params) {
                return null;
            }

            @Override
            public CompletableFuture<Either<List<? extends Location>, List<? extends LocationLink>>> implementation(ImplementationParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<? extends Location>> references(ReferenceParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<? extends DocumentHighlight>> documentHighlight(DocumentHighlightParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<Either<SymbolInformation, DocumentSymbol>>> documentSymbol(DocumentSymbolParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<Either<Command, CodeAction>>> codeAction(CodeActionParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<? extends CodeLens>> codeLens(CodeLensParams params) {
                return null;
            }

            @Override
            public CompletableFuture<CodeLens> resolveCodeLens(CodeLens unresolved) {
                return null;
            }

            @Override
            public CompletableFuture<List<? extends TextEdit>> formatting(DocumentFormattingParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<? extends TextEdit>> rangeFormatting(DocumentRangeFormattingParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<? extends TextEdit>> onTypeFormatting(DocumentOnTypeFormattingParams params) {
                return null;
            }

            @Override
            public CompletableFuture<WorkspaceEdit> rename(RenameParams params) {
                return null;
            }

            @Override
            public void willSave(WillSaveTextDocumentParams params) {

            }

            @Override
            public CompletableFuture<List<TextEdit>> willSaveWaitUntil(WillSaveTextDocumentParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<DocumentLink>> documentLink(DocumentLinkParams params) {
                return null;
            }

            @Override
            public CompletableFuture<DocumentLink> documentLinkResolve(DocumentLink params) {
                return null;
            }

            @Override
            public CompletableFuture<List<ColorInformation>> documentColor(DocumentColorParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<ColorPresentation>> colorPresentation(ColorPresentationParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<FoldingRange>> foldingRange(FoldingRangeRequestParams params) {
                return null;
            }

            @Override
            public CompletableFuture<Either<Range, PrepareRenameResult>> prepareRename(PrepareRenameParams params) {
                return null;
            }

            @Override
            public CompletableFuture<TypeHierarchyItem> typeHierarchy(TypeHierarchyParams params) {
                return null;
            }

            @Override
            public CompletableFuture<TypeHierarchyItem> resolveTypeHierarchy(ResolveTypeHierarchyItemParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<CallHierarchyItem>> prepareCallHierarchy(CallHierarchyPrepareParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<CallHierarchyIncomingCall>> callHierarchyIncomingCalls(CallHierarchyIncomingCallsParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<CallHierarchyOutgoingCall>> callHierarchyOutgoingCalls(CallHierarchyOutgoingCallsParams params) {
                return null;
            }

            @Override
            public CompletableFuture<List<SelectionRange>> selectionRange(SelectionRangeParams params) {
                return null;
            }

            @Override
            public void didOpen(DidOpenTextDocumentParams params) {

            }

            @Override
            public void didChange(DidChangeTextDocumentParams params) {

            }

            @Override
            public void didClose(DidCloseTextDocumentParams params) {

            }

            @Override
            public void didSave(DidSaveTextDocumentParams params) {

            }
        };
    }

    @Override
    public WorkspaceService getWorkspaceService() {
        return new WorkspaceService() {
            @Override
            public void didChangeConfiguration(DidChangeConfigurationParams didChangeConfigurationParams) {

            }

            @Override
            public void didChangeWatchedFiles(DidChangeWatchedFilesParams didChangeWatchedFilesParams) {

            }
        };
    }
}
