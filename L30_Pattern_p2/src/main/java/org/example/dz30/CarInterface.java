package org.example.dz30;

 interface CarInterface {
    public CarsImpl save(CarsImpl car);

    public CarsImpl load(String id);

    public void delete(String id);

    public CarsImpl update(CarsImpl car);
}
