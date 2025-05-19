package io.github.ink_song.tools.model;

public class CommandResult {
  final boolean Success;
  final String Message;

  public CommandResult(boolean success, String message) {
    Success = success;
    Message = message;
  }

  public String getMessage() {
    return Message;
  }

  public boolean isSuccess() {
    return Success;
  }

}
