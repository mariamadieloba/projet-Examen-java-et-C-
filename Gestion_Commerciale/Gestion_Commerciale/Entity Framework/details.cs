//------------------------------------------------------------------------------
// <auto-generated>
//     Ce code a été généré à partir d'un modèle.
//
//     Des modifications manuelles apportées à ce fichier peuvent conduire à un comportement inattendu de votre application.
//     Les modifications manuelles apportées à ce fichier sont remplacées si le code est régénéré.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Gestion_Commerciale.Entity_Framework
{
    using System;
    using System.Collections.Generic;
    
    public partial class details
    {
        public int commande_id { get; set; }
        public int article_id { get; set; }
        public int qteCmd { get; set; }
        public decimal prix { get; set; }
        public Nullable<decimal> montant { get; set; }
    
        public virtual article article { get; set; }
        public virtual commande commande { get; set; }
    }
}
