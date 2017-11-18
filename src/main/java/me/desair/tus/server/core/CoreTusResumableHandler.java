package me.desair.tus.server.core;

import me.desair.tus.server.*;
import me.desair.tus.server.upload.UploadIdFactory;
import me.desair.tus.server.upload.UploadStorageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Tus-Resumable header MUST be included in every request and response except for OPTIONS requests.
 * The value MUST be the version of the protocol used by the Client or the Server.
 */
public class CoreTusResumableHandler implements RequestHandler {

    @Override
    public boolean supports(final HttpMethod method) {
         return true;
    }

    @Override
    public void process(final HttpMethod method, final HttpServletRequest servletRequest, final TusServletResponse servletResponse, final UploadStorageService uploadStorageService, final UploadIdFactory idFactory) {
        //Always set Tus-Resumable header
        servletResponse.addHeader(HttpHeader.TUS_RESUMABLE, TusFileUploadHandler.TUS_API_VERSION);
    }
}