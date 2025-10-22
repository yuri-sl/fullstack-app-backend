package io.gith.quarkussocial.exception;


import io.gith.quarkussocial.dto.ErrorPayLoad;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class BookStockManagerExceptions implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable exception){
        if(exception instanceof PersistenceException &&
                exception.getCause() instanceof ConstraintViolationException){

            return Response.status(Response.Status.CONFLICT)
                    .entity(ErrorPayLoad.builder()
                            .codigoErro(409)
                            .message("Violação de restrição: Valor já cadastrado"))
                    .build();
        }

        if(exception instanceof jakarta.validation.ConstraintViolationException ex){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(ErrorPayLoad.builder()
                            .codigoErro(400)
                            .message("Erro de validação: "+ex.getMessage()))
                    .build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(ErrorPayLoad.builder()
                        .codigoErro(500)
                        .message("Erro interno: "+exception.getMessage())
                )
                .build();
    }
}
