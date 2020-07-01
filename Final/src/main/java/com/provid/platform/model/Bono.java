package com.provid.platform.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "bono")
public class Bono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// valores
	@Column(name = "v_nominal", nullable = false)
	private Double vNominal;

	@Column(name = "v_comercial", nullable = false)
	private Double vComercial;

	// numero de años
	@Column(name = "n_anio", nullable = false)
	private Integer nAnio;

	// frecuencia de pago
	@Column(name = "frec_pago", nullable = false)
	private Integer frecPago;

	// dias por año
	@Column(name = "dias_anio", nullable = false)
	private Integer diasxAnio;

	// valor de tasa
	@Column(name = "tipo_tasa", nullable = false)
	private Integer tipoTasa;

	@Column(name = "tasa", nullable = false)
	private Double tasa;

	// tipo de tasa
	@Column(name = "plazo_tasa", nullable = false)
	private Integer plazoTasa;

	// periodo de capitalizacion
	@Column(name = "periodo_capit")
	private Integer periodoCapit;

	// cok
	@Column(name = "cok", nullable = false)
	private Double cok;

	// tasa de ir
	@Column(name = "inflacion", nullable = false)
	private Double inflacion;

	// metodo
	@Column(name = "metodo", nullable = false)
	private Integer metodo;

	@Column(name = "moneda", nullable = false)
	private Integer moneda;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Debe ingresar una fecha.")
	@Column(name = "fecha", nullable = false)
	private Calendar fecha;

	// gastos iniciales
	@Column(name = "p_prima", nullable = false)
	private Double pPrima;

	@Column(name = "p_estructuracion", nullable = false)
	private Double pEstructuracion;

	@Column(name = "p_colocacion", nullable = false)
	private Double pColocacion;

	@Column(name = "p_flotacion", nullable = false)
	private Double pFlotacion;

	@Column(name = "p_cavali", nullable = false)
	private Double pCavali;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	private Client clientId;

	@OneToOne(mappedBy = "bonoId", cascade = CascadeType.ALL)
	private DetalleBono detalle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clienteId) {
		this.clientId = clienteId;
	}

	public Integer getMoneda() {
		return moneda;
	}

	public void setMoneda(Integer moneda) {
		this.moneda = moneda;
	}

	public Double getvNominal() {
		return vNominal;
	}

	public void setvNominal(Double vNominal) {
		this.vNominal = vNominal;
	}

	public Double getvComercial() {
		return vComercial;
	}

	public void setvComercial(Double vComercial) {
		this.vComercial = vComercial;
	}

	public Integer getDiasxAnio() {
		return diasxAnio;
	}

	public void setDiasxAnio(Integer diasxAnio) {
		this.diasxAnio = diasxAnio;
	}

	public Integer getFrecPago() {
		return frecPago;
	}

	public void setFrecPago(Integer frecPago) {
		this.frecPago = frecPago;
	}

	public Integer getMetodo() {
		return metodo;
	}

	public void setMetodo(Integer metodo) {
		this.metodo = metodo;
	}

	public Integer getTipoTasa() {
		return tipoTasa;
	}

	public void setTipoTasa(Integer tipoTasa) {
		this.tipoTasa = tipoTasa;
	}

	public Double getTasa() {
		return tasa;
	}

	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	public Double getCok() {
		return cok;
	}

	public void setCok(Double cok) {
		this.cok = cok;
	}

	public Double getInflacion() {
		return inflacion;
	}

	public void setInflacion(Double inflacion) {
		this.inflacion = inflacion;
	}

	public Double getpPrima() {
		return pPrima;
	}

	public void setpPrima(Double pPrima) {
		this.pPrima = pPrima;
	}

	public Double getpEstructuracion() {
		return pEstructuracion;
	}

	public void setpEstructuracion(Double pEstructuracion) {
		this.pEstructuracion = pEstructuracion;
	}

	public Double getpColocacion() {
		return pColocacion;
	}

	public void setpColocacion(Double pColocacion) {
		this.pColocacion = pColocacion;
	}

	public Double getpFlotacion() {
		return pFlotacion;
	}

	public void setpFlotacion(Double pFlotacion) {
		this.pFlotacion = pFlotacion;
	}

	public Double getpCavali() {
		return pCavali;
	}

	public void setpCavali(Double pCavali) {
		this.pCavali = pCavali;
	}

	public Integer getnAnio() {
		return nAnio;
	}

	public void setnAnio(Integer nAnio) {
		this.nAnio = nAnio;
	}

	public Integer getPlazoTasa() {
		return plazoTasa;
	}

	public void setPlazoTasa(Integer plazoTasa) {
		this.plazoTasa = plazoTasa;
	}

	public Integer getPeriodoCapit() {
		return periodoCapit;
	}

	public void setPeriodoCapit(Integer periodoCapit) {
		this.periodoCapit = periodoCapit;
	}

	public DetalleBono getDetalle() {
		return detalle;
	}

	public void setDetalle(DetalleBono detalle) {
		this.detalle = detalle;
	}

	// aproximar a 7 y 2 digitos

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public double aprox7digit(double result) {
		return (double) Math.round(result * 10000000d) / 10000000;
	}

	public double aprox2digit(double result) {
		return (double) Math.round(result * 100d) / 100;
	}

	public String frecuenciaPago() {
		String result = "";
		if (frecPago == 30) {
			result = "Mensual";
		} else if (frecPago == 60) {
			result = "Bimestral";
		} else if (frecPago == 90) {
			result = "Trimestral";
		} else if (frecPago == 120) {
			result = "Cuatrimestral";
		} else if (frecPago == 180) {
			result = "Semestral";
		} else if (frecPago == 360) {
			result = "Anual";
		}
		return result;
	}

	public String frecuenciaTasa() {
		String result = "";
		if (plazoTasa == 30) {
			result = "Mensual";
		} else if (plazoTasa == 60) {
			result = "Bimestral";
		} else if (plazoTasa == 90) {
			result = "Trimestral";
		} else if (plazoTasa == 120) {
			result = "Cuatrimestral";
		} else if (plazoTasa == 180) {
			result = "Semestral";
		} else if (plazoTasa == 360) {
			result = "Anual";
		}
		return result;
	}

	public String metodo() {
		String result = "";
		if (metodo == 1) {
			result = "Americano";
		} else if (metodo == 2) {
			result = "Alemán";
		} else if (metodo == 3) {
			result = "Francés";
		}
		return result;
	}

	public String moneda() {
		String result = "";
		if (moneda == 1) {
			result = "Nuevos Soles";
		} else if (moneda == 2) {
			result = "Dólares Americanos";
		} else if (moneda == 3) {
			result = "Euros";
		}
		return result;
	}

	public String simbolo() {
		String result = "";
		if (moneda == 1) {
			result = "S/.";
		} else if (moneda == 2) {
			result = "US$";
		} else if (moneda == 3) {
			result = " \u20AC";
		}
		return result;
	}

	public Double precioSoles() {
		Double result = 0.0;

		if (moneda == 1) {
			result = aprox2digit(precio() * 1.0);
		} else if (moneda == 2) {
			result = aprox2digit(precio() * 3.52);
		} else if (moneda == 3) {
			result = aprox2digit(precio() * 3.95);
		}
		return result;
	}

	public String capitalizacion() {
		String result = "";
		if (periodoCapit == 1) {
			result = "Diaria";
		} else if (periodoCapit == 15) {
			result = "Quincenal";
		} else if (periodoCapit == 30) {
			result = "Mensual";
		} else if (periodoCapit == 60) {
			result = "Bimestral";
		} else if (periodoCapit == 90) {
			result = "Trimestral";
		} else if (periodoCapit == 120) {
			result = "Cuatrimestral";
		} else if (periodoCapit == 180) {
			result = "Semestral";
		} else if (periodoCapit == 360) {
			result = "Anual";
		}
		return result;
	}

	public String tipoTasa() {
		String result = "";

		if (tipoTasa == 1) {
			result = "Efectiva";
		} else if (tipoTasa == 2) {
			result = "Nominal";
		}
		return result;
	}

	public Integer periodosxAnio() {
		int result = 0;
		result = diasxAnio / frecPago;
		return result;
	}

	public Integer periodosTotales() {
		return nAnio * periodosxAnio();
	}

	public Double TEA() {
		Double result = 0.0;
		if (tipoTasa == 1) {
			result = (Math.pow(1.00 + (tasa * 1.0 / 100.0), (360 * 1.0) / (plazoTasa * 1.0)) - 1.00) * 100.0;
		} else if (tipoTasa == 2) {
			double m = (plazoTasa * 1.0) / (periodoCapit * 1.0);
			double n = (diasxAnio * 1.0) / (periodoCapit * 1.0);
			result = (Math.pow(1.00 + ((tasa * 1.0 / 100.0) / m), n) - 1.00) * 100.0;
		}
		return aprox7digit(result);
	}

	public Double TEP() {
		Double result = 0.0;
		result = (Math.pow(1.00 + (TEA() * 1.0 / 100.0), (frecPago * 1.0) / (diasxAnio * 1.0)) - 1.00) * 100.0;
		return aprox7digit(result);
	}

	public Double COKP() {
		Double result = 0.0;
		result = ((Math.pow((1.00 + (cok * 1.0 / 100.0)), (frecPago * 1.0) / (diasxAnio * 1.0)) - 1.00) * 100.0);
		return aprox7digit(result);
	}

	public Double inflacionP() {
		Double result = 0.0;
		result = ((Math.pow((1.00 + (inflacion * 1.0 / 100.0)), (frecPago * 1.0) / (diasxAnio * 1.0)) - 1.00) * 100.0);
		return aprox7digit(result);
	}

	public List<Double> bonoIndex() {
		List<Double> bono = new ArrayList<Double>();

		for (int i = 0; i < periodosTotales(); i++) {
			if (i == 0) {
				bono.add(i, vNominal * (1 + (inflacionP() * 1.0 / 100.0)));
			} else if (i != 0) {
				bono.add(i, bono.get(i - 1) * (1 + (inflacionP() * 1.0 / 100.0)));
			}
		}
		return bono;
	}

	// todos los metodos
	public Double costosBonista() {
		Double result = 0.0;
		result = (((pFlotacion + pCavali) * 1.0) / 100.0) * vComercial;
		return aprox2digit(result);
	}

	public Double costosEmisor() {
		double result = 0.0;
		result = (((pFlotacion + pCavali + pEstructuracion + pColocacion) * 1.0) / 100.0) * vComercial;
		return aprox2digit(result);
	}

	public Double ciBonista() {
		double result = 0.0;
		result = -((vComercial + costosBonista()) * 1.0);
		return aprox2digit(result);
	}

	public Double ciEmisor() {
		double result = 0.0;
		result = ((vComercial - costosEmisor()) * 1.0);
		return aprox2digit(result);
	}

//	bonista americano
	public List<Double> flujoBonistaAme() {
		List<Double> flujo = new ArrayList<Double>();

		for (int i = 0; i <= periodosTotales(); i++) {

			if (i == 0) {
				flujo.add(i, ciBonista());

			} else if (0 < i && i < periodosTotales()) {

				flujo.add(i, aprox2digit(bonoIndex().get(i - 1) * (TEP() * 1.0 / 100.0)));

			} else if (i == periodosTotales()) {

				flujo.add(i, aprox2digit((bonoIndex().get(i - 1) * ((((pPrima + TEP()) * 1.0) / 100.0) + 1.0))));
			}
		}
		return flujo;
	}

	public Double tirBonistaAme() {
		Double tir = 0.0;
		Double aux;

		do {
			aux = 0.0;
			tir += 0.00001;

			for (int i = 0; i <= periodosTotales(); i++) {
				aux += flujoBonistaAme().get(i) / Math.pow((1 + tir / 100), i);
			}
		} while (aux > 0);
		return aprox7digit(tir);
	}

//	emisor americano
	public List<Double> flujoEmisorAme() {
		List<Double> flujo = new ArrayList<Double>();

		for (int i = 0; i <= periodosTotales(); i++) {

			if (i == 0) {
				flujo.add(i, ciEmisor());

			} else if (0 < i && i < periodosTotales()) {

				flujo.add(i, -aprox2digit(bonoIndex().get(i - 1) * (TEP() * 1.0 / 100.0)));

			} else if (i == periodosTotales()) {

				flujo.add(i, -aprox2digit((bonoIndex().get(i - 1) * ((((pPrima + TEP()) * 1.0) / 100.0) + 1.0))));
			}
		}
		return flujo;
	}

	public Double tirEmisorAme() {
		Double tir = 0.0;
		Double aux;

		do {
			aux = 0.0;
			tir += 0.00001;

			for (int i = 0; i <= periodosTotales(); i++) {
				aux += flujoEmisorAme().get(i) / Math.pow((1 + tir / 100), i);
			}
		} while (aux < 0);
		return aprox7digit(tir);
	}

// 	precio americano
	public Double precioAmericano() {
		double result = 0.0;
		for (int i = 0; i <= periodosTotales(); i++) {
			if (i != 0) {
				result += ((flujoBonistaAme().get(i)) / (Math.pow((1 + ((COKP() * 1.0) / 100.0)), i)));
			}
		}
		return aprox2digit(result);
	}

//	aleman
	public List<Double> flujoBonistaAle() {
		List<Double> flujo = new ArrayList<Double>();
		List<Double> cupon = new ArrayList<Double>();
		List<Double> cuota = new ArrayList<Double>();
		List<Double> amort = new ArrayList<Double>();
		List<Double> bono = new ArrayList<Double>();

		for (int i = 0; i < periodosTotales(); i++) {
			if (i == 0) {
				bono.add(i, vNominal * (1 + (inflacionP() * 1.0 / 100.0)));
				amort.add(i, -(bono.get(i) / (periodosTotales() - (i + 1) + 1)));
				cupon.add(i, -(TEP() / 100.0) * bono.get(i));
				cuota.add(i, cupon.get(i) + amort.get(i));

			} else if (i != 0) {
				bono.add(i, (bono.get(i - 1) + amort.get(i - 1)) * (1 + (inflacionP() * 1.0 / 100.0)));
				amort.add(i, -(bono.get(i) / (periodosTotales() - (i + 1) + 1)));
				cupon.add(i, -(TEP() / 100.0) * bono.get(i));
				cuota.add(i, cupon.get(i) + amort.get(i));
			}
		}

		for (int i = 0; i <= periodosTotales(); i++) {

			if (i == 0) {
				flujo.add(i, ciBonista());

			} else if (0 < i && i < periodosTotales()) {

				flujo.add(i, -aprox2digit(cuota.get(i - 1)));

			} else if (i == periodosTotales()) {

				flujo.add(i, aprox2digit(((bono.get(i - 1) * pPrima * 1.0) / 100.0) - cuota.get(i - 1)));
			}
		}
		return flujo;
	}

	public List<Double> flujoEmisorAle() {
		List<Double> flujo = new ArrayList<Double>();
		List<Double> cupon = new ArrayList<Double>();
		List<Double> cuota = new ArrayList<Double>();
		List<Double> amort = new ArrayList<Double>();
		List<Double> bono = new ArrayList<Double>();

		for (int i = 0; i < periodosTotales(); i++) {
			if (i == 0) {
				bono.add(i, vNominal * (1 + (inflacionP() * 1.0 / 100.0)));
				amort.add(i, -(bono.get(i) / (periodosTotales() - (i + 1) + 1)));
				cupon.add(i, -(TEP() / 100.0) * bono.get(i));
				cuota.add(i, cupon.get(i) + amort.get(i));

			} else if (i != 0) {
				bono.add(i, (bono.get(i - 1) + amort.get(i - 1)) * (1 + (inflacionP() * 1.0 / 100.0)));
				amort.add(i, -(bono.get(i) / (periodosTotales() - (i + 1) + 1)));
				cupon.add(i, -(TEP() / 100.0) * bono.get(i));
				cuota.add(i, cupon.get(i) + amort.get(i));
			}
		}

		for (int i = 0; i <= periodosTotales(); i++) {

			if (i == 0) {
				flujo.add(i, ciEmisor());

			} else if (0 < i && i < periodosTotales()) {

				flujo.add(i, aprox2digit(cuota.get(i - 1)));

			} else if (i == periodosTotales()) {

				flujo.add(i, aprox2digit(((-bono.get(i - 1) * pPrima * 1.0) / 100.0) + cuota.get(i - 1)));
			}
		}
		return flujo;
	}

//	tir aleman
	public Double tirBonistaAle() {
		Double tir = 0.0;
		Double aux;

		do {
			aux = 0.0;
			tir += 0.00001;

			for (int i = 0; i <= periodosTotales(); i++) {
				aux += flujoBonistaAle().get(i) / Math.pow((1 + tir / 100), i);
			}
		} while (aux > 0);
		return aprox7digit(tir);
	}

	public Double tirEmisorAle() {
		Double tir = 0.0;
		Double aux;

		do {
			aux = 0.0;
			tir += 0.00001;

			for (int i = 0; i <= periodosTotales(); i++) {
				aux += flujoEmisorAle().get(i) / Math.pow((1 + tir / 100), i);
			}
		} while (aux < 0);
		return aprox7digit(tir);
	}

// precio aleman
	public Double precioAleman() {
		double result = 0.0;
		for (int i = 0; i <= periodosTotales(); i++) {
			if (i != 0) {
				result += ((flujoBonistaAle().get(i)) / (Math.pow((1 + ((COKP() * 1.0) / 100.0)), i)));
			}
		}
		return aprox2digit(result);
	}

	// frances
	public List<Double> flujoEmisorFra() {
		List<Double> flujo = new ArrayList<Double>();
		List<Double> cupon = new ArrayList<Double>();
		List<Double> cuota = new ArrayList<Double>();
		List<Double> amort = new ArrayList<Double>();
		List<Double> bono = new ArrayList<Double>();

		for (int i = 0; i < periodosTotales(); i++) {
			if (i == 0) {
				bono.add(i, vNominal * (1 + (inflacionP() * 1.0 / 100.0)));
				cuota.add(i,
						-bono.get(i)
								* (((TEP() / 100.0) * (Math.pow((TEP() / 100.0) + 1, periodosTotales() - (i + 1) + 1)))
										/ (Math.pow(1 + (TEP() / 100.0), periodosTotales() - (i + 1) + 1) - 1)));
				cupon.add(i, -(TEP() / 100.0) * bono.get(i));
				amort.add(i, cuota.get(i) - cupon.get(i));
			} else if (i != 0) {
				bono.add(i, (bono.get(i - 1) + amort.get(i - 1)) * (1 + (inflacionP() * 1.0 / 100.0)));
				cuota.add(i,
						-bono.get(i)
								* (((TEP() / 100.0) * (Math.pow((TEP() / 100.0) + 1, periodosTotales() - (i + 1) + 1)))
										/ (Math.pow(1 + (TEP() / 100.0), periodosTotales() - (i + 1) + 1) - 1)));
				cupon.add(i, -(TEP() / 100.0) * bono.get(i));
				amort.add(i, cuota.get(i) - cupon.get(i));
			}
		}

		for (int i = 0; i <= periodosTotales(); i++) {
			if (i == 0) {
				flujo.add(i, ciEmisor());
			} else if (0 < i && i < periodosTotales()) {
				flujo.add(i, aprox2digit(cuota.get(i - 1)));
			} else if (i == periodosTotales()) {
				flujo.add(i, aprox2digit(cuota.get(i - 1) - (bono.get(i - 1) * (pPrima / 100.0))));
			}
		}

		return flujo;
	}

	public List<Double> flujoBonistaFra() {
		List<Double> flujo = new ArrayList<Double>();
		List<Double> cupon = new ArrayList<Double>();
		List<Double> cuota = new ArrayList<Double>();
		List<Double> amort = new ArrayList<Double>();
		List<Double> bono = new ArrayList<Double>();

		for (int i = 0; i < periodosTotales(); i++) {
			if (i == 0) {
				bono.add(i, vNominal * (1 + (inflacionP() * 1.0 / 100.0)));
				cuota.add(i,
						-bono.get(i)
								* (((TEP() / 100.0) * (Math.pow((TEP() / 100.0) + 1, periodosTotales() - (i + 1) + 1)))
										/ (Math.pow(1 + (TEP() / 100.0), periodosTotales() - (i + 1) + 1) - 1)));
				cupon.add(i, -(TEP() / 100.0) * bono.get(i));
				amort.add(i, cuota.get(i) - cupon.get(i));
			} else if (i != 0) {
				bono.add(i, (bono.get(i - 1) + amort.get(i - 1)) * (1 + (inflacionP() * 1.0 / 100.0)));
				cuota.add(i,
						-bono.get(i)
								* (((TEP() / 100.0) * (Math.pow((TEP() / 100.0) + 1, periodosTotales() - (i + 1) + 1)))
										/ (Math.pow(1 + (TEP() / 100.0), periodosTotales() - (i + 1) + 1) - 1)));
				cupon.add(i, -(TEP() / 100.0) * bono.get(i));
				amort.add(i, cuota.get(i) - cupon.get(i));
			}
		}

		for (int i = 0; i <= periodosTotales(); i++) {
			if (i == 0) {
				flujo.add(i, aprox2digit(ciBonista()));
			} else if (0 < i && i < periodosTotales()) {
				flujo.add(i, -aprox2digit(cuota.get(i - 1)));
			} else if (i == periodosTotales()) {
				flujo.add(i, -aprox2digit(cuota.get(i - 1) - (bono.get(i - 1) * (pPrima / 100.0))));
			}
		}

		return flujo;
	}

	public Double tirBonistaFra() {
		Double tir = 0.0;
		Double aux;

		do {
			aux = 0.0;
			tir += 0.00001;

			for (int i = 0; i <= periodosTotales(); i++) {
				aux += flujoBonistaFra().get(i) / Math.pow((1 + tir / 100), i);
			}
		} while (aux > 0);
		return aprox7digit(tir);
	}

	public Double tirEmisorFra() {
		Double tir = 0.0;
		Double aux;

		do {
			aux = 0.0;
			tir += 0.00001;

			for (int i = 0; i <= periodosTotales(); i++) {
				aux += flujoEmisorFra().get(i) / Math.pow((1 + tir / 100), i);
			}
		} while (aux < 0);
		return aprox7digit(tir);
	}

	public Double precioFrances() {
		double result = 0.0;
		for (int i = 0; i <= periodosTotales(); i++) {
			if (i != 0) {
				result += ((flujoBonistaFra().get(i)) / (Math.pow((1 + ((COKP() * 1.0) / 100.0)), i)));
			}
		}
		return aprox2digit(result);
	}

	// finales
	public List<Double> flujoBonista() {
		List<Double> flujo = new ArrayList<Double>();

		if (metodo == 1) {
			flujo = flujoBonistaAme();
		} else if (metodo == 2) {
			flujo = flujoBonistaAle();
		} else if (metodo == 3) {
			flujo = flujoBonistaFra();
		}
		return flujo;
	}

	public List<Double> flujoEmisor() {
		List<Double> flujo = new ArrayList<Double>();

		if (metodo == 1) {
			flujo = flujoEmisorAme();
		} else if (metodo == 2) {
			flujo = flujoEmisorAle();
		} else if (metodo == 3) {
			flujo = flujoEmisorFra();
		}
		return flujo;
	}

	public Double tirEmisor() {
		double result = 0.0;

		if (metodo == 1) {
			result = tirEmisorAme();
		} else if (metodo == 2) {
			result = tirEmisorAle();
		} else if (metodo == 3) {
			result = tirEmisorFra();
		}

		return result;
	}

	public Double tirBonista() {
		double result = 0.0;

		if (metodo == 1) {
			result = tirBonistaAme();
		} else if (metodo == 2) {
			result = tirBonistaAle();
		} else if (metodo == 3) {
			result = tirBonistaFra();
		}

		return result;
	}

	public Double treaBonista() {
		double result = 0.0;

		if (metodo == 1) {
			result = aprox7digit(
					(Math.pow(1.00 + (tirBonistaAme() * 1.0 / 100.0), (360 * 1.0) / (frecPago * 1.0)) - 1.00) * 100.0);
		} else if (metodo == 2) {
			result = aprox7digit(
					(Math.pow(1.00 + (tirBonistaAle() * 1.0 / 100.0), (360 * 1.0) / (frecPago * 1.0)) - 1.00) * 100.0);
		} else if (metodo == 3) {
			result = aprox7digit(
					(Math.pow(1.00 + (tirBonistaFra() * 1.0 / 100.0), (360 * 1.0) / (frecPago * 1.0)) - 1.00) * 100.0);
		}

		return result;
	}

	public Double tceaEmisor() {
		double result = 0.0;

		if (metodo == 1) {
			result = aprox7digit(
					(Math.pow(1.00 + (tirEmisorAme() * 1.0 / 100.0), (360 * 1.0) / (frecPago * 1.0)) - 1.00) * 100.0);
		} else if (metodo == 2) {
			result = aprox7digit(
					(Math.pow(1.00 + (tirEmisorAle() * 1.0 / 100.0), (360 * 1.0) / (frecPago * 1.0)) - 1.00) * 100.0);
		} else if (metodo == 3) {
			result = aprox7digit(
					(Math.pow(1.00 + (tirEmisorFra() * 1.0 / 100.0), (360 * 1.0) / (frecPago * 1.0)) - 1.00) * 100.0);
		}

		return result;
	}

	public Double precio() {
		double result = 0.0;

		if (metodo == 1) {
			result = precioAmericano();
		} else if (metodo == 2) {
			result = precioAleman();
		} else if (metodo == 3) {
			result = precioFrances();
		}
		return result;
	}

	public List<String> mostrarBonista() {
		List<String> flujo = new ArrayList<String>();
		Calendar result = getFecha();

		for (int i = 0; i <= periodosTotales(); i++) {

			if (i == 0) {
				result.add(Calendar.DATE, 0);
				flujo.add(i,
						"Cuota N° " + i + " (" + result.getTime().getDate() + "-" + (result.getTime().getMonth() + 1)
								+ "-" + (result.getTime().getYear() + 1900) + ") : " + " " + simbolo() + " "
								+ flujoBonista().get(i));

			} else if (i != 0) {
				result.add(Calendar.DATE, frecPago);
				flujo.add(i,
						"Cuota N° " + i + " (" + result.getTime().getDate() + "-" + (result.getTime().getMonth() + 1)
								+ "-" + (result.getTime().getYear() + 1900) + ") : " + simbolo() + " "
								+ flujoBonista().get(i));
			}
		}

		return flujo;
	}

	public List<String> mostrarEmisor() {
		List<String> flujo = new ArrayList<String>();
		Calendar result = getFecha();

		for (int i = 0; i <= periodosTotales(); i++) {

			if (i == 0) {
				result.add(Calendar.DATE, 0);
				flujo.add(i,
						"Cuota N° " + i + " (" + result.getTime().getDate() + "-" + (result.getTime().getMonth() + 1)
								+ "-" + (result.getTime().getYear() + 1900) + ") : " + " " + simbolo() + " "
								+ flujoEmisor().get(i));

			} else if (i != 0) {
				result.add(Calendar.DATE, frecPago);
				flujo.add(i,
						"Cuota N° " + i + " (" + result.getTime().getDate() + "-" + (result.getTime().getMonth() + 1)
								+ "-" + (result.getTime().getYear() + 1900) + ") : " + simbolo() + " "
								+ flujoEmisor().get(i));
			}
		}
		return flujo;
	}

	public Double utilidad() {
		Double u = 0.0;

		if (metodo == 1) {
			u = precioAmericano() + flujoBonistaAme().get(0);
		} else if (metodo == 2) {
			u = precioAleman() + flujoBonistaAle().get(0);
		} else if (metodo == 3) {
			u = precioFrances() + flujoBonistaFra().get(0);
		}

		return aprox2digit(u);
	}

	public Double utilidadSoles() {
		Double u = 0.0;

		if (moneda == 1) {
			u = aprox2digit((precioAmericano() + flujoBonistaAme().get(0)) * 1.0);
		} else if (moneda == 2) {
			u = aprox2digit((precioAleman() + flujoBonistaAle().get(0)) * 3.52);
		} else if (moneda == 3) {
			u = aprox2digit((precioFrances() + flujoBonistaFra().get(0)) * 3.95);
		}

		return u;
	}
}