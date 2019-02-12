package com.lianyihui.hongdong.data.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.UUID;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse {


	private String id;
	private String message;
	private int status;
	private Object result;

	public APIResponse(Throwable t, int status) {
		this(t.getLocalizedMessage(), status);
	}

	public APIResponse(String message) {
		this(message, 0);
	}

	public APIResponse(Object result, String message) {
		this(message);
		this.result = result;
	}


	public APIResponse(String message, int status) {
		this(UUID.randomUUID().toString(), message, status);
	}

	public APIResponse(String id, String message) {
		this(id, message, 0);
	}

	public APIResponse(String id, String message, int status) {
		this.id = id;
		this.message = message;
		this.status = status;
	}


	public static APIResponse ok() {
		return new APIResponse("ok");
	}

	public static APIResponse ok(String id) {
		return new APIResponse(id, "ok");
	}

	public static APIResponse result(Object result) {
		return new APIResponse(result, "ok");
	}
}

