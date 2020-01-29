package com.islamistudio.rss.data.source.remote;

import androidx.annotation.NonNull;

public class ApiResponse<T> {

    @NonNull
    public final StatusResponse status;

    @NonNull
    public final String message;

    @NonNull
    public final T body;

    public ApiResponse(@NonNull StatusResponse status, @NonNull T body, @NonNull String message) {
        this.status = status;
        this.message = message;
        this.body = body;
    }

    public static <T> ApiResponse<T> success(@NonNull T body) {
        return new ApiResponse<>(StatusResponse.SUCCESS, body, null);
    }

    public static <T> ApiResponse<T> empty(String msg, @NonNull T body) {
        return new ApiResponse<>(StatusResponse.EMPTY, body, msg);
    }

    public static <T> ApiResponse<T> error(String msg, @NonNull T body) {
        return new ApiResponse<>(StatusResponse.ERROR, body, msg);
    }

}
