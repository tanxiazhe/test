package com.test.sudoku;

import java.util.Map;

public class HttpResponseInfo {
  private String status;
  private String bodyStr;
  private Map<String, String> headers;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getBodyStr() {
    return bodyStr;
  }

  public void setBodyStr(String bodyStr) {
    this.bodyStr = bodyStr;
  }

  public Map<String, String> getHeaders() {
    return headers;
  }

  public void setHeaders(Map<String, String> headers) {
    this.headers = headers;
  }
}
