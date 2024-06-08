export interface Fatture {
    numeroFattura: string;
    data: string;
    importo: number;
    statoFattura: string;
    cliente: {
      id: number;
      email: string;
      ragioneSociale: string;
    };
  }
