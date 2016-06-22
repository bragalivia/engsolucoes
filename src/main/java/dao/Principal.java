package dao;

import business.ImportExcel;
import dao.impl.InsumosRepositoryImpl;
import rest.model.Insumo;

import java.util.List;

/**
 * Created by Livia on 21/06/2016.
 */
public class Principal {
    public static void main(String[] args) {
        ImportExcel excel = new ImportExcel();
        String fileName = "C:\\Users\\Livia\\Desktop\\database1.xlsx";
        String origemDatabaseName = "Caio";

        //TODO
//        if (origem.has(fileName)) {
//            if(sobrescrever()) {
//                deleteDatabase(origemDatabaseName);
//            } else {
//                origemDatabaseName = "novoDatabaseName";
//            }
//        }

        List<Insumo> listInsumo = excel.readExcel(fileName, origemDatabaseName);
        InsumosRepository insumosRepository = new InsumosRepositoryImpl();

        for (Insumo insumo : listInsumo) {
            insumosRepository.create(insumo);
            System.out.println("criado"+insumo.getCodigo());
        }
    }
}
