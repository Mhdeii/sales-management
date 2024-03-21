package Mahdi.com.salesmanagement.service;

import com.example.sales.model.Sale;
import com.example.sales.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Optional<Sale> getSaleById(Long id) {
        return saleRepository.findById(id);
    }

    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale updateSale(Long id, Sale updatedSale) {
        Optional<Sale> optionalSale = saleRepository.findById(id);
        if (optionalSale.isPresent()) {
            Sale sale = optionalSale.get();
            sale.setCreationDate(updatedSale.getCreationDate());
            sale.setClient(updatedSale.getClient());
            sale.setSeller(updatedSale.getSeller());
            sale.setTotal(updatedSale.getTotal());
            return saleRepository.save(sale);
        } else {
            return null; // Handle not found scenario
        }
    }

    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
}
