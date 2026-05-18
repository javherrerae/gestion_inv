package logistica.producto.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "desconsolidacion")
public interface DesconsolidacionClient {

    @GetMapping("/api/desconsolidaciones/{idDesconsolidacion}")
    ResponseEntity<?> buscarPorId(@PathVariable("idDesconsolidacion") Long idDesconsolidacion);
}