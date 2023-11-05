package com.PimientaPasion.Sprint4.services;

import com.PimientaPasion.Sprint4.VerPeidosClientedtos.*;
import com.PimientaPasion.Sprint4.entities.*;
import com.PimientaPasion.Sprint4.enums.EstadoPedido;
import com.PimientaPasion.Sprint4.repositories.BaseRepository;
import com.PimientaPasion.Sprint4.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido,Long> implements PedidoService  {

    @Autowired
    PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public List<PedidoVerPedidoDTO> buscarPeidosCliente(Long id_cliente, Pageable pageable) throws Exception {
        try {
            Page<Pedido> pedidos= pedidoRepository.buscarPeidosCliente(id_cliente,pageable);
            ModelMapper modelMapper = new ModelMapper();
            List<PedidoVerPedidoDTO> pedidoVerPedidoDTOS =new ArrayList<PedidoVerPedidoDTO>();

            for (Pedido pedido:pedidos){
                pedidoVerPedidoDTOS.add(modelMapper.map(pedido, PedidoVerPedidoDTO.class));
            }
            return pedidoVerPedidoDTOS;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public PedidoVerDetalleDTO verDetallePedido(Long id) throws Exception {
        try {
            Pedido pedido=pedidoRepository.verDetallePedido(id);
            ModelMapper modelMapper=new ModelMapper();
            List<DetallePedidoVerDetalleDTO> detallePedidoVerDetalleDTOS=new ArrayList<DetallePedidoVerDetalleDTO>();
            DetallePedidoVerDetalleDTO detallePedidoVerDetalleDTOAux;
            PedidoVerDetalleDTO pedidoVerDetalleDTO=modelMapper.map(pedido,PedidoVerDetalleDTO.class);
            for (DetallePedido detallePedido:pedido.getDetallePedidos()){
                detallePedidoVerDetalleDTOAux=modelMapper.map(detallePedido,DetallePedidoVerDetalleDTO.class);
                detallePedidoVerDetalleDTOAux.setProductoVerDatalleDTO(modelMapper.map(detallePedido.getProducto(), ProductoVerDatalleDTO.class));
                detallePedidoVerDetalleDTOS.add(detallePedidoVerDetalleDTOAux);
            }
            pedidoVerDetalleDTO.setDetallePedidoVerDetalleDTOS(detallePedidoVerDetalleDTOS);
            return pedidoVerDetalleDTO;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public FacturaVerFacturaDTO verFacturaPedido(Long id) throws Exception {
        try{
            Factura factura=pedidoRepository.verFacturaPedido(id);
            ModelMapper modelMapper=new ModelMapper();
            FacturaVerFacturaDTO facturaVerFacturaDTO=modelMapper.map(factura,FacturaVerFacturaDTO.class);
            List<DetalleFacturaVerFacturaDTO> detalleFacturaVerFacturaDTOS = new ArrayList<DetalleFacturaVerFacturaDTO>();
            DetalleFacturaVerFacturaDTO detalleFacturaVerFacturaDTOAux;
            for (DetalleFactura detalleFactura:factura.getDetalleFactura()){
                detalleFacturaVerFacturaDTOAux=(modelMapper.map(detalleFactura, DetalleFacturaVerFacturaDTO.class));
                detalleFacturaVerFacturaDTOAux.setProductoVerDatalleDTO(modelMapper.map(detalleFactura.getProducto(),ProductoVerDatalleDTO.class));
                detalleFacturaVerFacturaDTOS.add(detalleFacturaVerFacturaDTOAux);
            }
            facturaVerFacturaDTO.setDetalleFacturaVerFacturaDTOS(detalleFacturaVerFacturaDTOS);
            return facturaVerFacturaDTO;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Pedido> buscarPedidoPorEstado(EstadoPedido pedido_estado) throws Exception {
        try{
            List<Pedido>pedidos=pedidoRepository.buscarPedidoPorEstado(pedido_estado);
            return  pedidos;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
