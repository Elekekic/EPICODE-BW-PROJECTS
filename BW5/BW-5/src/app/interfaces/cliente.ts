import { Fatture } from "./fatture"

export interface Cliente {

        id: number,
        dataInserimento: Date,
        dataUltimocontatto: Date,
        ragioneSociale: string,
        partitaIva: string,
        email: string,
        tipoCliente : string ,
        fatturatoAnnuale : number,
        pec : string ,
        telefono : number ,
        emailContatto :  string ,
        nomeContatto : string ,
        cognomeContatto : string ,
        telefonoContatto : number ,
        indirizzi : [
            {
                via : string ,
                comune : any ,
                cap :  number ,
                localita :  string ,
                civico : number,
                tipoIndirizzo : string
            }
        ]
    }
